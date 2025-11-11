# Kube Utils Changelog

## [21.1.3]

### Fixed

- `ListKu.getRandomWeightedEntry` no longer breaks when given valid data

## [21.1.2]

### Fixed

- Issues with KubeJS 7.2+

## [21.1.1]

### Added 

- `findFirstBlockTagWithinRadius` to find a block within a radius that has a specific block tag.
- `findAnyEntitiesWithinRadius` to find any entities within a radius based on an entity type.
- `findLivingEntitiesWithinRadius` to find living entities within a radius based on an entity type.

### Deprecated

- `findEntitiesWithinRadius` in favour of `findLivingEntitiesWithinRadius`

## [21.1.0]

### Changed

- Updated to 1.21.1 thanks to [@Saereth](https://github.com/Saereth)
