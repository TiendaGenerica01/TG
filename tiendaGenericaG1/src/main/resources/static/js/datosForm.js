const listado = document.querySelector("#listado");

listado.addEventListener('click', e => {
	if(e.target.matches('.boton-editar')) {
		const fila = e.target.parentNode.parentNode;				
		const datosFila = Array.from(fila.children).filter(child =>	child.children.length === 0);	
		
		llenarDatosFormulario(datosFila);
		
	}	
});

function llenarDatosFormulario(datos) {
	
	const inputsFormActualizar = Array.from(document.querySelector('#formActualizar').elements);
		
	for(i = 0; i < datos.length; ++i) {
		inputsFormActualizar[i].value = datos[i].textContent;	
	}	
}