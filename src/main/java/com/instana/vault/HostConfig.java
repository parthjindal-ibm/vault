package com.instana.vault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class HostConfig {
    @JsonProperty("host.system")
    private String hostSystem;
    private final List<ConcurrentHashMap<String, Object>> instances = new ArrayList<>();
    @JsonProperty(value = "vault", required = false)
    private VaultServiceConfig vaultConfig;

    @JsonIgnore
    public boolean isVaultServiceConfigPresent() {
        return Optional.ofNullable(vaultConfig).isPresent();
    }

    public VaultServiceConfig getVaultServiceConfig() {
        return vaultConfig;
    }

    public String getHostSystem() {
        return hostSystem;
    }

    public List<ConcurrentHashMap<String, Object>> getInstances() {
        return instances;
    }
}
