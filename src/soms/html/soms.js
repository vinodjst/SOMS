function changeText() {
  document.getElementById("test").innerHTML = "<h2>Hello World</h2>"
}

const usernameInputEl = document.getElementById("uname")
const passwordInputEl = document.getElementById("pass")
const loginFormEl = document.getElementById("login-form")



document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();

    window.location.href = "dashboard.html";
});

loginFormEl.addEventListener("submit", (e) => {
  e.preventDefault()
//  validateUser()
})

function validateUser() {
  //validate user input value
  const usernameInputVal = usernameInputEl.value.trim()
  if (usernameInputVal === "") {
    alert("Username cannot be empty")
  } else if (usernameInputVal.length > 6) {
    alert("Username should not be more than 6 chars")
  } else {
    for (let i = 0; i < usernameInputVal.length; i++) {
      if (isSpecialChar(usernameInputVal, i)) {
        alert("Username should not contain special chars")
      }
    }
  }
  //validate password input value
  const passwordInputVal = passwordInputEl.value
  validatePassword(passwordInputVal)
}


//regex pattern
function validatePassword(str) {
  let hasAlphabetChar = false
  let hasNumericChar = false
  let hasSpecialChar = false

  for (let i = 0; i < str.length; i++) {
    const code = str.charCodeAt(i)
    if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {
      hasAlphabetChar = true
    }
    if (code >= 48 && code <= 57) {
      hasNumericChar = true
    }
    if (isSpecialChar(str, i)) {
      hasSpecialChar = true
    }
  }
  console.log(`${hasAlphabetChar},  ${hasNumericChar}, ${hasSpecialChar}`)
  if (hasAlphabetChar && hasNumericChar && hasSpecialChar) {
    return
  } else {
    alert(
      "Password should contain atleast 1 numeric, 1 char and 1 special char",
    )
  }
}

function isSpecialChar(str, idx) {
  const code = str.charCodeAt(idx)
  if (
    (code >= 65 && code <= 90) ||
    (code >= 97 && code <= 122) ||
    (code >= 48 && code <= 57)
  ) {
    return false
  }
  return true
}

// function validateUser(){

//     console.log('inside validateUser() function');
//      var userName = document.getElementById('uname').value;
//      var pass = document.getElementById('pass').value;

//   // username/password
//   //you need validate
//   //username - should not be blank /characters not more than 6/should not contain special char
//   //password - should contain 1 numeric/ char/special char

//      window.alert('Hello '+userName);
//      window.alert('confirm password '+pass);

// }