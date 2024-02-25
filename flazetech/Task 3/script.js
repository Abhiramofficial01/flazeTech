// Dummy user data (for demonstration purposes)
const userAccount = {
    userId: "12345",
    userPin: "6789",
    balance: 0.0,
    transactions: []
};

// Dummy recipient data (for demonstration purposes)
const recipientAccount = {
    userId: "56789",
    userPin: "0000",
    balance: 0.0,
    transactions: []
};

function showElement(elementId) {
    const element = document.getElementById(elementId);
    element.classList.remove("hidden");
}

function hideElement(elementId) {
    const element = document.getElementById(elementId);
    element.classList.add("hidden");
}

function login() {
    const enteredUserId = document.getElementById("userId").value;
    const enteredPin = document.getElementById("pin").value;

    if (userAccount.userId === enteredUserId && userAccount.userPin === enteredPin) {
        hideElement("login");
        showElement("menu");
    } else {
        document.getElementById("output").innerText = "Invalid User ID or PIN. Exiting...";
    }
}

function showHistory() {
    const historyOutput = userAccount.transactions.map(transaction =>
        `${transaction.type}: $${transaction.amount}`
    ).join("<br>");

    document.getElementById("output").innerHTML = `Transaction History:<br>${historyOutput}`;
}

function showWithdraw() {
    const withdrawAmount = prompt("Enter withdrawal amount:");
    userAccount.withdraw(parseFloat(withdrawAmount));

    showHistory();
}

function showDeposit() {
    const depositAmount = prompt("Enter deposit amount:");
    userAccount.deposit(parseFloat(depositAmount));

    showHistory();
}

function showTransfer() {
    const recipientId = prompt("Enter recipient's User ID:");
    const transferAmount = prompt("Enter transfer amount:");

    recipientAccount.transfer(userAccount, parseFloat(transferAmount));

    showHistory();
}

function quit() {
    document.getElementById("output").innerText = "Quitting ATM. Thank you!";
    hideElement("menu");
    showElement("login");
}
