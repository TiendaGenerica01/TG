const mensajeAlerta = document.querySelector('#mensajeAlerta').value;
const iconoAlerta = document.querySelector('#iconoAlerta').value;

console.log(mensajeAlerta);

if(mensajeAlerta !== '' && mensajeAlerta !== 'null') {
	Swal.fire({
  		title: mensajeAlerta,
  		icon: iconoAlerta,
  		timer: 2500
	});
}
