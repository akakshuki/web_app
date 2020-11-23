package c1808g1.aem_api.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.modelmapper.config.Configuration.AccessLevel;

public class ModelMapperConfig {
    public static final ModelMapper modelMapper = new ModelMapper();

    ModelMapperConfig() {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
          .stream()
          .map(element -> modelMapper.map(element, targetClass))
          .collect(Collectors.toList());
    }
}
