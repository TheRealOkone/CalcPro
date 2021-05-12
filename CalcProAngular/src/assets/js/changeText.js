
function changeText(value) {
  if (document.getElementById('count').value == "Введите ваш пример")  document.getElementById('count').value = value;
  else
  if ((value == "DEL")&&(value != "")) document.getElementById('count').value = document.getElementById('count').value.slice(0, -1);
  else
  if (value == "CLR")  document.getElementById('count').value = "Введите ваш пример";
  else if (value != "DEL")
  {
    if ((value == '-')||(value == '+')||(value == '*')||(value == '/')) document.getElementById('count').value += ' ';
    document.getElementById('count').value += value;
    if ((value == '-')||(value == '+')||(value == '*')||(value == '/')) document.getElementById('count').value += ' ';
  }
}
