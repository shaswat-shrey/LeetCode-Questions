const $ = id => document.getElementById(id);

const rules = {
  name:   v => /^[A-Za-z][A-Za-z .]{1,49}$/.test(v.trim())   || "Enter your full name (letters only).",
  roll:   v => /^[A-Za-z0-9]{4,15}$/.test(v.trim())          || "Enter a valid roll number.",
  mobile: v => /^[0-9]{10}$/.test(v.trim())                  || "Mobile number must be exactly 10 digits.",
  email:  v => /^[^\s@]+@[^\s@.]+\.[A-Za-z]{2,}$/.test(v.trim()) || "Enter an email with @ and a domain, e.g. you@college.edu.",
  course: v => v !== ""                                      || "Choose a course.",
  pwd:    v => (v.length >= 8 && /[A-Z]/.test(v) && /[0-9]/.test(v) && /[^A-Za-z0-9]/.test(v))
                                                             || "Needs 8+ characters with an uppercase letter, a number and a symbol.",
  cpwd:   v => (v !== "" && v === $("pwd").value)            || "Passwords do not match.",
  terms:  () => $("terms").checked                           || "Accept the terms to continue."
};

function check(id){
  const el = $(id), box = el.closest("[data-field]");
  const res = rules[id](el.type === "checkbox" ? "" : el.value);
  box.classList.toggle("err", res !== true);
  box.querySelector(".msg").textContent = res === true ? "" : res;
  return res === true;
}

Object.keys(rules).forEach(id => {
  const el = $(id);
  el.addEventListener("blur", () => check(id));
  el.addEventListener("input", () => { if (el.closest("[data-field]").classList.contains("err")) check(id); });
  el.addEventListener("change", () => check(id));
});

$("mobile").addEventListener("input", e => e.target.value = e.target.value.replace(/\D/g, ""));

$("form").addEventListener("submit", e => {
  e.preventDefault();
  const valid = Object.keys(rules).map(check).every(Boolean);
  $("ok").style.display = valid ? "block" : "none";
  if (!valid) document.querySelector(".err input, .err select")?.focus();
  else console.log({
    name: $("name").value.trim(), roll: $("roll").value.trim(),
    email: $("email").value.trim(), mobile: $("mobile").value,
    course: $("course").value
  });
});