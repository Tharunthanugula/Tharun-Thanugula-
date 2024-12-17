let startTime = null;
let elapsedTime = 0;
let timerInterval = null;

const timeDisplay = document.querySelector('.time-display');
const startBtn = document.getElementById('start-btn');
const pauseBtn = document.getElementById('pause-btn');
const resetBtn = document.getElementById('reset-btn');
const lapBtn = document.getElementById('lap-btn');
const lapsList = document.querySelector('.laps');

function updateTimeDisplay() {
  const totalMilliseconds = elapsedTime + (Date.now() - startTime);
  const milliseconds = Math.floor((totalMilliseconds % 1000) / 10);
  const seconds = Math.floor(totalMilliseconds / 1000) % 60;
  const minutes = Math.floor(totalMilliseconds / 60000);

  timeDisplay.textContent = `${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}:${String(milliseconds).padStart(2, '0')}`;
}

function startTimer() {
  startTime = Date.now();
  timerInterval = setInterval(updateTimeDisplay, 10);
  startBtn.disabled = true;
  pauseBtn.disabled = false;
  lapBtn.disabled = false;
}

function pauseTimer() {
  elapsedTime += Date.now() - startTime;
  clearInterval(timerInterval);
  startBtn.disabled = false;
  pauseBtn.disabled = true;
}

function resetTimer() {
  clearInterval(timerInterval);
  startTime = null;
  elapsedTime = 0;
  updateTimeDisplay();
  startBtn.disabled = false;
  pauseBtn.disabled = true;
  lapBtn.disabled = true;
  lapsList.innerHTML = '';
}

function recordLap() {
  const lapTime = timeDisplay.textContent;
  const lapItem = document.createElement('li');
  lapItem.textContent = lapTime;
  lapsList.appendChild(lapItem);
}

startBtn.addEventListener('click', startTimer);
pauseBtn.addEventListener('click', pauseTimer);
resetBtn.addEventListener('click', resetTimer);
lapBtn.addEventListener('click', recordLap);
