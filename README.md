# Springboot-Mini-Project


## Table of contents

- [Overview](#overview)
  - [The challenge](#the-challenge)
  - [Screenshot](#screenshot)
  - [Links](#links)
- [My process](#my-process)
  - [Built with](#built-with)
  - [What I learned](#what-i-learned)
  - [Continued development](#continued-development)
  - [Useful resources](#useful-resources)
- [Acknowledgments](#acknowledgments)

## Overview

### The challenge

Users should be able to:

- Start a new tic tac toe game
- Click on a square to add X first and then O, and so on
- Be shown a message after each turn for if I win, lose, tie or who's turn it is next
- Not be able to click the same square twice
- Shown a message when I win, lose or tie
- Not be able to continue playing once I win, lose, or tie
- Play the game again without refreshing the page
- **Bonus**: Keep track of multiple game rounds with a win, lose and tie counter
- **Bonus**: Make your site fully responsive so that it is playable from a mobile phone
- **Bonus**: Get inventive with your styling e.g. use hover effects or animations
- **Bonus**: Involve Audio in your game

### Screenshot
*Wireframe*
<img src="Screenshot\Wireframe 1.png" alt ="wireframe image" width="50%">

*Desktop*
<img src="Screenshot\game-desktop-3.png" alt ="game in desktop image" height="50%">

*Tablet*
<img src="Screenshot\game-tablet.jpg" alt ="game in tablet image" width="50%">

*Mobile*
<img src="Screenshot\game-mobile.jpg" alt ="game in mobile image" width="40%">

### Links

- Solution URL: [Github Solution](https://github.com/woodsdeshe/Tic-Tac-Toe)
- Live Site URL: [Tic Tac Toe Deployed Site](https://woodsdeshe.github.io/Tic-Tac-Toe/)

## My process

### Built with

- ![](	https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
)
- ![](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white
)
- ![](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
- ![](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black
)
- ![](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white
)
- ![](https://img.shields.io/badge/Google_chrome-4285F4?style=for-the-badge&logo=Google-chrome&logoColor=white
)
- ![](https://img.shields.io/badge/prettier-1A2C34?style=for-the-badge&logo=prettier&logoColor=F7BA3E)

### What I learned
- I struggled with how to handle the reset function and how to reset all of the pieces on the board when the reset button is clicked. After helping another classmate, I realized that I could use forEach to remove all of the square content. I was also able to incorporate the classList method that we practiced in class to remove the styling that was being added on the board.
```js
//This function resets the game
function resetGame() {
  tile.forEach((square) => {
    square.textContent = "";
    square.classList.remove("x-symbol");
    square.classList.remove("o-symbol");
  });
  message.textContent = "Press Start to Play";
  currentPlayer = "X";
  gameOver = false;
}
```
```css
.x-symbol {
    color: #b87bf1;
    background-color: #b87bf152;
}

.o-symbol {
    color: #53f0c1;
    background-color: #53f0c18c;
}
```
- I also had some difficulties trying to incorporate simple resposive design in my code and had to do a creash course in Bootstrap in order to simplify the proces. Being able to figure out how to recreate my game board using Boostrap was challenging but very rewarding.
```html
 <div class="container game-board">
            <div class="row">
              <div class="col-4">
                <div class="tile square-1"></div>
              </div>
              <div class="col-4">
                <div class="tile square-2"></div>
              </div>
              <div class="col-4">
                <div class="tile square-3"></div>
              </div>
            </div>
```
- Utlilzing the things that I learned within Bootstrap, I was able to add additional styling to the code, so that the game could respond well on mobile devices.
```css
@media (max-width: 767px) {
  .scoreboard {
    width: 150px;
    font-size: 16px;
  }

  .score-x,
  .score-o {
    font-size: 1.5em;
  }

  .game-board {
    margin: 10px;
  }

  .tile {
    width: 100px;
    height: 100px;
    font-size: 30px;
  }

  .startBtn,
  .reset-btn {
    font-size: 16px;
    padding: 5px 10px;
  }
}
```
 

### Continued development

- Array methods: I was able to discover more methods for arays like the .every method, but it was still something that I struggled to incorporate into my code. I hope to be able to use these methods more for future projects.

- Bootstrap: It was so helpful being able to use this framework within my code. I want to explore it more and see how I can use it to create more interesting and simple UX/UI for future and current projects

### Useful resources

- [Grid System - Bootstrap](https://getbootstrap.com/docs/5.3/layout/grid/) - This website helped me to execute some of the styling that I created in the wireframe. This also helped with the gameboard formatting and easy spacing within the style of the game.
- [MDN](https://developer.mozilla.org/en-US/) - This site helped me with understanding certain methods for arrays and how to utitlize them in my code

## Acknowledgments

I want to give a shout out to Dominique C. and Claire! By collaborating with them, I was able to practice effective communication and different ways of problem solving and debugging.

I also want to thank Dominique C. (again) and Suresh for letting me know about Bootstrap and helping me find the right documentation =.
