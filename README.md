# 🎥 Part 1: Iterator Pattern

## 🚀 Overview
This project demonstrates the implementation of the **Iterator** pattern using the example of "Streaming‑Service Binge Mode". We hide the insides of episode collections and provide a single way to bypass them.

## , Repository structure
```
part1/
├─ Episode.java
├─ EpisodeView.java
├─ Season.java
├─ Series.java
├─ EpisodeIterator.java
├─ SeasonIterator.java
├─ ReverseSeasonIterator.java
├─ ShuffleSeasonIterator.java
├─ BingeIterator.java
├─ SkipIntroIterator.java
├─ UnseenEpisodeIterator.java
├─ Main.java
└─ README.md
```

## , Features
- 🔄**Normal**, **Reverse**, **Shuffle** single season bypass
- 📺 **BingeIterator**: gluing seasons without manual transitions
- ⏩ **SkipIntroIterator**: Skipping the first n seconds of each episode
- 👀 **UnseenEpisodeIterator**: filtering already watched episodes
- 🎯 Support for `for-each` via `Iterable` in `Season`

## 💡 Why Iterator?
- Hides the implementation of collections and reduces connectivity
- Allows you to expand functionality (new crawling and filtering modes) without editing the client code
- Conforms to the principles of **SOLID**:
  - **S**ingle Responsibility (each iterator does only its own thing)
- **O**pen/Closed (it's easy to add a new bypass mode)
- **L**iskov Substitution (replacing iterators without problems)
- **I**nterface Segregation (minimal interface)
- **D**ependency Inversion (the client depends on the 'EpisodeIterator` interface)

- Part 2: Airport Tower Simulator

## ✈️ Overview
Pattern classification **Intermediary** +**Strategy** for communication management and resource allocation/posad.

## 📂 Structure
```
part2/
├─ src/part2/
│  ├─ TowerMediator.java
│  ├─ RunwayScheduler.java
│  ├─ FuelPriorityScheduler.java
│  ├─ VipPriorityScheduler.java
│  ├─ ControlTower.java
│  ├─ Aircraft.java
│  ├─ PassengerPlane.java
│  ├─ CargoPlane.java
│  ├─ Helicopter.java
│  ├─ Simulation.java
└─ README.md

## , Features
- 🎯 **Control tower** as an operator for requests
- 🔄 **Strategy**: `FuelPriorityScheduler', `VipPriorityScheduler' (changing in runtime)
- "Last night"/meeting with the prime minister for the extreme "MAY DAY"
- 🕹️ `Passenger plane`, 'Cargo plane', `Helicopter`
- ⏱️ **Simulation** * Scheduled Support Service

# Why do you need an intermediary + strategy?
- The intermediary integrates the logic of aircraft control from the tower
- A resource-based strategy allows flexible policy management due to ControlTower management`
- The combination of patterns reduces related changes and improves extensibility

## 🛠️ Launch
``bash
cd part2/src/part2
javac *.java
java simulation
```

- After the start, after 10 seconds of the demo, you can dynamically change the strategy:
`java
  // Main simulation method:
Thread.sleep(10000);
  tower.setScheduler(new VipPriorityScheduler());
  System.out.println("
=== Switched to VIP Priority Scheduler===");
  ```
- As a result, landings/takeoffs will be redistributed according to the new policy.

## Reflection Reflection
The file `Reflection.md To support a detailed analysis (1 page):
- The role of a patter mediator against direct government intervention
- Disadvantage: the risk of "God-object" and complicated logic centralization testing

## 📋 Decryption from the console
`text
[12:00:00] PP1 Actions
PP1 is queued for boarding.
The runway is provided by PP1 (landing)
Passenger aircraft console PP1: Allowed for landing

[12:00:03] PP2 actions
!!! PP2 EMERGENCY!!!
PP2 Passenger Aircraft Control console: Hold position: runway emergency
The runway is immediately provided with PP2

[12:00:10] === Switched to VIP Priority Scheduler ===
[12:00:11] CP2 Actions
CP2 is queued for takeoff.
Runway provided by CP2 (take-off)
CargoPlane CP2 Console: Takeoff allowed
`
![image](https://github.com/user-attachments/assets/d45fbc8c-f029-4265-9509-71636232a3be)
