document.addEventListener('DOMContentLoaded', function () {
    const lowerBound = 1;
    const upperBound = 100;
    const generatedNumber = Math.floor(Math.random() * (upperBound - lowerBound + 1)) + lowerBound;

    let maxAttempts = 5;
    let currentAttempt = 0;
    let score = 0;

    document.getElementById('attempts').innerText = `Attempts left: ${maxAttempts}`;

    window.checkGuess = function () {
        const userGuess = parseInt(document.getElementById('guessInput').value);
        currentAttempt++;

        if (userGuess === generatedNumber) {
            document.getElementById('result').innerText = `Congratulations! You guessed the number in ${currentAttempt} attempts.`;
            score += (maxAttempts - currentAttempt + 1) * 10;
            document.getElementById('score').innerText = `Your score: ${score}`;
        } else if (userGuess < generatedNumber) {
            document.getElementById('result').innerText = 'Too low. Try again!';
        } else {
            document.getElementById('result').innerText = 'Too high. Try again!';
        }

        document.getElementById('attempts').innerText = `Attempts left: ${maxAttempts - currentAttempt}`;

        if (currentAttempt === maxAttempts) {
            document.getElementById('result').innerText = `Game Over. The number was: ${generatedNumber}`;
        }
    };
});
