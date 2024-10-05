import React, { useState } from 'react';

function App() {
  const [inputValue, setInputValue] = useState(''); 
  const [responseText, setResponseText] = useState(''); 

  const handleClick = async () => {
    try {
      const response = await fetch(`http://localhost:8080/traceip?ip=${inputValue}`);
      const data = await response.text(); 
      setResponseText(data); 
    } catch (error) {
      setResponseText('Error al obtener los datos ' + error);
    }
  };

  return (
    <div>
      <h1>IP Tracker</h1>
      <input
        type="text"
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
        placeholder="Ingresa una IP"
      />
      <button onClick={handleClick}>Enviar</button>
      <div>
        <h2>Respuesta:</h2>
        <p>{responseText}</p>
      </div>
    </div>
  );
}

export default App;