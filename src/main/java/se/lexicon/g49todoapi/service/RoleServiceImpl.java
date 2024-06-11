package se.lexicon.g49todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.converter.RoleConverter;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.domanin.entity.Role;
import se.lexicon.g49todoapi.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }



    @Override
    public List<RoleDTOView> getAll() {
        List <Role> roles =roleRepository.findAll();
        List<RoleDTOView> roleDTOViewsList = new ArrayList<>();

        for (Role entity : roles) {

            roleDTOViewsList.add(roleConverter.toRoleDTO(entity));
        }
        return roleDTOViewsList;
    }
}
