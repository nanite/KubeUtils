# Kube Utils Documentation

Kube Utils is a relatively simple addon mod made for KubeJS. I've taken some of the more annoying things to interface with in Minecraft and KubeJS through set of utilities and class wrappers to ease the complication and performance issues introduced when using KubeJS code extensively.

## Disclaimer

> Kube Utils is specifically driven by my specific use cases and thus the scope of the modules may seem limited. If you have something you'd like to be added to KubeUtils, let me know and I'll see if it's possible and get it added if it is :D

## Modules

Each module KubeUtils introduces is always prefixed with the `Ku` namespace. Each module aims to improve a specific element of Minecraft / KubeJS and will typically never do anything outside of that specific element.

Utilising modules is simple in KubeJS. The `Ku` namespace is always available but sometimes you may need to construct a `Ku` module and sometimes you can just use it.

Each module below denotes if it's a `static` or `constructed` module through the use of the `static` and `constructed` tags. A `static` module is one you can just use. No need to create it. A `contructed` module is a module you need to create in order to be able to use. A good example of this would be the `players` module. You use this module by calling `new Ku.Player(your_mc_player_object)`. This is in contract to a `static` module like `utils` where you can just use it. For example `Ku.Utils.nullOrEmpty(the_object_you_want_to_check)` 

### [Player `Ku.Player` `constructed`](modules/player.md)

The player module introduces some helpful methods like `showActionBar`, `isClientSide` and the ability to `clearStartItemsFlag` which is part of the Starter items system within KubeUitls

### [Level `Ku.Level` `constructed`](modules/level.md)

The level module is currently focused on providing simple methods for dealing with structures, getting blocks within a specific area, spawning structures and finding random location.

### [Fluids `Ku.Fluid` `static`](modules/fluids.md)

The fluids module allows you to get fluids by namespace, by multiple namespaces, the ability to check if a fluid is empty or not empty. This module is still being actively expanded.

### [Lists `Ku.Lists` `static`](modules/lists.md)

The lists module right now is very limited, but it does provide the ability to get an random entry based on a weight based system.

### [Streams `Ku.Streams` `static`](modules/streams.md)

The Streams module is also very limited right now. You can currently use this module to take a list of `BlockPos` entries and convert them into `BlockContainerJS` entries.

## Systems

Unlike the modules above, systems are create with the idea of adding 'pre-made' features that you can use Ku or KubeJS to interface with. Right now, we only have 1 system but I'm open to suggestions

### [Starter items](systems/starter-items.md)

This system is intended for modpack developers. It provides the ability to define a list of items that a player should be given when they spawn into the level for the first time. 

