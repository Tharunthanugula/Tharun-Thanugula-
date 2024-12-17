
const board = document.getElementById("board");
const resetButton = document.getElementById("reset");
const winnerText = document.getElementById("winner");


let gameBoard = ["", "", "", "", "", "", "", "", ""];
let currentPlayer = "X";
let gameActive = true;


function renderBoard() {
  board.innerHTML = "";  
  gameBoard.forEach((cell, index) => {
    const square = document.createElement("div");
    square.classList.add("square");
    square.textContent = cell;
    square.addEventListener("click", () => handleClick(index));
    board.appendChild(square);
  });
}


function handleClick(index) {
  if (gameBoard[index] !== "" || !gameActive) return;  
  gameBoard[index] = currentPlayer;
  checkWinner();
  currentPlayer = currentPlayer === "X" ? "O" : "X";  
  renderBoard();
}


function checkWinner() {
  const winningCombinations = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8], 
    [0, 3, 6], [1, 4, 7], [2, 5, 8], 
    [0, 4, 8], [2, 4, 6]  
  ];

  for (let combination of winningCombinations) {
    const [a, b, c] = combination;
    if (gameBoard[a] !== "" && gameBoard[a] === gameBoard[b] && gameBoard[a] === gameBoard[c]) {
      gameActive = false;
      winnerText.textContent = `Player ${gameBoard[a]} wins!`;
      return;
    }
  }

  
  if (!gameBoard.includes("")) {
    gameActive = false;
    winnerText.textContent = "It's a draw!";
  }
}


resetButton.addEventListener("click", () => {
  gameBoard = ["", "", "", "", "", "", "", "", ""];
  currentPlayer = "X";
  gameActive = true;
  winnerText.textContent = "";
  renderBoard();
});


renderBoard();
