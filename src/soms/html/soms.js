function changeText() {
  document.getElementById("test").innerHTML = "<h2>Hello World</h2>"
}

const usernameInputEl = document.getElementById("uname")
const passwordInputEl = document.getElementById("pass")
const loginFormEl = document.getElementById("login-form")

loginFormEl.addEventListener("submit", (e) => {
  e.preventDefault()

  const isValidUser = validateUser()

  // 👉 Only redirect if everything is valid
  if (isValidUser) {
    alert("Login Successful ✅")

    // redirect to dashboard
    window.location.href = "dashboard.html"
  }
})

function validateUser() {
  const usernameInputVal = usernameInputEl.value.trim()

  // Username validation
  if (usernameInputVal === "") {
    alert("Username cannot be empty")
    return false
  } else if (usernameInputVal.length > 6) {
    alert("Username should not be more than 6 chars")
    return false
  } else {
    for (let i = 0; i < usernameInputVal.length; i++) {
      if (isSpecialChar(usernameInputVal, i)) {
        alert("Username should not contain special chars")
        return false
      }
    }
  }

  // Password validation
  const passwordInputVal = passwordInputEl.value
  const isValidPass = validatePassword(passwordInputVal)

  return isValidPass
}

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

  if (hasAlphabetChar && hasNumericChar && hasSpecialChar) {
    return true
  } else {
    alert("Password should contain atleast 1 numeric, 1 char and 1 special char")
    return false
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