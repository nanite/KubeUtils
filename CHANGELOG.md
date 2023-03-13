# Kube Utils Changelog

## [1.0.2]

### Added

- Added a new Level method to allow for finding a single block within an area `findSingleBlockWithinRadius`
- Added a `triggeredBy` field to the `KuEvents.playerStarterItems` event as we now trigger the event for a player joining as well as a player changing dimension. If the event does not place and item in the inventory. We assume it failed and will retry on either a join or a dimension change
