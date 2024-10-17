package pc.leon.service;

import pc.leon.entitites.Composer;

import java.util.*;

public class ComposerService {
    private Map<String, Composer> composerMap;

    public ComposerService() {
        composerMap = new HashMap<>();
    }

    public Set<Composer> getOrCreate(List<String> composerList) {
        Set<Composer> composerSet = new HashSet<>();
        composerList.forEach(
                composerName -> {
                    composerSet.add(
                            composerMap.computeIfAbsent(composerName, Composer::new)
                    );
                });
        return composerSet;
    }
}
