package dev.ocean.mirrorverse.configs.impl;

import dev.ocean.mirrorverse.configs.ConfigService;
import dev.ocean.mirrorverse.configs.impl.handler.DataType;
import dev.ocean.mirrorverse.configs.impl.handler.IDataAccessor;
import dev.ocean.mirrorverse.utils.ConfigFile;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum SettingsLocale implements IDataAccessor {
    DEBUG("debug", DataType.BOOLEAN, "false"),
    MONGO("mongo-url", DataType.STRING, "mongodb://localhost:27017"),
    ;

    private final String path;
    private final List<String> defaultValue = new ArrayList<>();
    private final DataType dataType;

    SettingsLocale(String path, DataType dataType, String... defaultValue) {
        this.path = path;
        this.defaultValue.addAll(Arrays.asList(defaultValue));
        this.dataType = dataType;
    }

    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public ConfigFile getConfigFile() {
        return ConfigService.getInstance().getSettingsConfig();
    }
}
