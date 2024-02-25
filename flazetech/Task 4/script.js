function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

  
    //  let's assume the username is "admin" and password is "admin123"
    if (username === "admin" && password === "admin123") {
        // Redirect to the online examination page or perform other actions
        alert("Login successful! Redirecting to the examination page.");
       
    } else {
        alert("Invalid username or password. Please try again.");
    }
}
