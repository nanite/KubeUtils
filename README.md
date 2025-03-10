# Kube Utils

Kube Utils is a simple addon to KubeJS which adds new functionality to existing features and branches off to create new systems that allow for more performant, simplified, and concise code.

## How it works

Kube Utils (Ku from now on) has been designed with the concept of a clear, concise, and consistent API like design. Everything added by this mod is held within the global `Ku` object meaning if you want to access level apis, you will access it via `Ku.Level`, if you want to do something with fluids you will use `Ku.Fluids` etc.

### Features

Currently, we only have a few helpers to some of the lesser supported areas of KubeJS but we plan to expand this greatly over the life cycle of the systems development. If you have any suggestions, please make a feature request!

- Level additions like being able to get structures at a block pos, ability to spawn structures, find entities and clear spaces, get a random location with a bounding box, etc.
- Fluids, allow you to get a list of fluids based on their namespace(s), and being able to check if a fluid is empty or not.
- List additions like getting random entries based on a weighted table
- The addition of general utilities like `nullOrEmpty` which gives you a very simply way to always know if an object is nullOrEmpty whether it's a item, block, itemstack, string, fluid or itemEntity! (more support to come as required) 
- Completely documented code
- Production validated
- Clear and simple API

### Our goals

- We aim to never make breaking changes unless absolutely forced to by Minecraft, Forge or Fabric. At the point we feel we need to branch off and make breaking changes, it will be done in an optional way that will not affect existing code.
- Never to make the additions overly complex
- Always document the additions in plain English

## TODO 

- [ ] Expand the modules (looking for suggestions)

## Documentation

Our goal is to release a website that documents all of the new additions and how to use them. 

Right now, you can read up on the features we add from within the code. Our `BaseBinding` class shows you which objects you can use in the `Ku` object. For example `BaseBindings` contains `Streams` as a field. This means you can use `Ku.Steams.MethodName`. You can find the available methods from within the related `modules` class file. If you see a field surrounded by `ClassWrapper<?>` this means to use the field in KubeJS, you will have to create the object. For example, `Level` is wrapped with `ClassWrapper<LevelUtils>` meaning you will need to use the field like this `new Ku.Level(player.level)`. It's a touch complicated but once the website is ready, it will be much simpler.

## Disclaimer

Disclaimer, whist in beta, expect possible code breaking changes. Once we hit stable release, this message will be removed and from that point onwards, the code will not contain breaking changes!

## Issues

Please report any issues to [our issue tracker](https://github.com/ErrorMikey/KubeUtils/issues) along with example code so we can validate the issues.
