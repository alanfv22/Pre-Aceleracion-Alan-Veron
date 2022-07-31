package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.DTOS.PersonajeFiltersDTO;
import com.alkemy.disney.DTOS.PersonajeUpdateDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repository.PersonajeRepository;
import com.alkemy.disney.repository.specifications.PersonajeSpecifications;
import com.alkemy.disney.services.Interfaces.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    private PersonajeMapper personajeMapper;

    private PersonajeRepository personajeRepository;

    private PersonajeSpecifications personajeSpecifications;

    @Autowired
    public PersonajeServiceImpl(PersonajeMapper personajeMapper, PersonajeRepository personajeRepository, PersonajeSpecifications personajeSpecifications) {
        this.personajeMapper = personajeMapper;
        this.personajeRepository = personajeRepository;
        this.personajeSpecifications = personajeSpecifications;
    }


    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        //No se puede crear un personaje con el mismo nombre
        Optional<PersonajeEntity> personaje = personajeRepository.findByNombre(dto.getNombre());

        if (personaje.isPresent()) {
            throw new ParamNotFound("El personaje ya existe");
        } else {
            PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
            PersonajeEntity personajeSave = personajeRepository.save(entity);
            PersonajeDTO res = personajeMapper.personajeEntity2DTO(personajeSave, false);
            return res;
        }
    }

    @Override
    public PersonajeDTO update(PersonajeUpdateDTO personajeUpdateDTO) {

        if (!personajeRepository.existsById(personajeUpdateDTO.getPersonajeId()))
            throw new ParamNotFound("El personaje no existe");

        else {
            PersonajeEntity personaje = personajeRepository.getReferenceById(personajeUpdateDTO.getPersonajeId());
            PersonajeDTO personajeDTO = personajeMapper.personajeEntity2DTO(personaje, true);
            PersonajeDTO res = personajeMapper.personajeUpdateDTO2personajeFullDTO(personajeDTO, personajeUpdateDTO);
            personajeMapper.refreshValues(personaje, res);
            personajeRepository.save(personaje);

            return res;
        }
    }

    @Override
    public List<PersonajeBasicDTO> getByFilters(String nombre, int edad, Set<Long> peliculas, float peso) {
        PersonajeFiltersDTO personajeFiltersDTO = new PersonajeFiltersDTO(nombre, edad, peliculas, peso);
        List<PersonajeEntity> entities = personajeRepository.findAll(this.personajeSpecifications.getByFilters(personajeFiltersDTO));
        List<PersonajeBasicDTO> dto = personajeMapper.personajeEntitySet2DTOList(entities);

        return dto;
    }

    @Override
    public void delete(Long id) {

        if (!personajeRepository.existsById(id))
            throw new ParamNotFound("El personaje no existe");
        else
            personajeRepository.deleteById(id);

    }

    @Override
    public PersonajeDTO getById(Long id) {

        if (!personajeRepository.existsById(id))
            throw new ParamNotFound("El personaje no existe");

        else {
            PersonajeEntity entiti = personajeRepository.getById(id);
            PersonajeDTO ret = personajeMapper.personajeEntity2DTO(entiti, true);
            return ret;
        }


    }
}
