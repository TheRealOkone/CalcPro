
function getRequest() {
  let url = new URL('http://localhost:8080/home');
  url.searchParams.set('req', document.getElementById('count').value);
  url.searchParams.set('fmod', 0);
  let xhr = new XMLHttpRequest();
  xhr.open("POST", url, [true]);
  xhr.send();
  xhr.onload = function() {
    if (xhr.status != 200) {
      alert(`Ошибка ${xhr.status}: ${xhr.statusText}`);
    } else {
      document.getElementById('count').value = xhr.responseText+' ';
    }
  };

}
