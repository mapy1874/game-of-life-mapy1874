# COMP401 A8 - *mapy1874's Game Of Life*

**[mapy1874's Game Of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)** is an is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

Time spent: **15** hours spent in total

## User Stories

The following functionality is completed:
- Ability to change the size of the field from 10x10 up to 500x500.
- Ability to manually set / clear any cell in order to set up patterns
- Ability to clear the entire field.
- Ability to fill the field randomly.
- Ability to advance the game by pressing a button.
- Written with a Model View Controller architecture
- Ability to set the "survive" and "birth" thresholds to custom values. The default threshold values in the classic game brings a dead cell to life if the number of neighboring live cells is greater than or equal to 2 (low birth threshold) and less than or equal to 3 (high birth threshold) and otherwise stays dead. A living cell survives if the number of neighboring live cells is greater than or equal to 3 (low survive threshold) and less than or equal to 3 (high survive threshold) and otherwise will de. 
- Ability to toggle "torus" mode on or off. In torus mode, the field is treated as if it wraps around the edges back to the other edge.
- A start/stop button that advances the game automatically using a separate thread with a delay between updates settable between 10 milliseconds and 1 second.

## Video Walkthrough

Here's a walkthrough of implemented user stories:


<img src='https://github.com/mapy1874/game-of-life-mapy1874/blob/master/GameOfLifeWalkthrough.gif' title='Video Walkthrough' />


GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes
- I did not want to do the extra credit at first due to JSpot's implementation costs a lot of time and I no little about MVC. It was KMP'S 
MVC lecture code that enlightened me to finish all functionality of the app.

## Application Framework used

- [java swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html) - an API for providing a graphical user interface (GUI) for Java programs

## License

    Copyright [2019] [Peiyuan Ma]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.## User Stories
