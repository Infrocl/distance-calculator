import React, { useState } from 'react';
import Alert from 'react-bootstrap/Alert';

const CalculateDistance = () => {
    const [requests, setRequests] = useState([]);
    const [response, setResponse] = useState([]);
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);
    
    const handleAddRequest = () => {
        setRequests([...requests, { type: '', fromCity: '', toCity: '' }]);
        setError(null);
        setSuccess(false)
    }
    
    const handleInputChange = (index, e) => {
        const { name, value } = e.target;
        const updatedRequests = [...requests];
        updatedRequests[index][name] = value;
        setRequests(updatedRequests);
    }
    
    const handleCalculateDistance = async () => {
        try {
            const response = await fetch('http://localhost:3000/cities/calculate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requests)
            });
            console.log(response)
            const data = await response.json();
            if (response.status === 200) {
                setResponse(data);
                setRequests([]);
                setSuccess("Рассчёт успешно выполнен!");
            } else {
                setError("Ошибка рассчёта: проверьте правильность написания типа рассчёта или id городов")
            }
        } catch (error) {
            setError(error.message)
        }
    }
    
    return (
        <div>
            {requests.map((request, index) => (
                <div key={index} >
                    <label className="calc-label"> Тип рассчёта:</label>
                    <input className="item" type="text" name="type" value={request.type} onChange={e => handleInputChange(index, e)} />
                    <br />
                    <label className="calc-label" >Id города "от":</label>
                    <input className="item" type="number" name="fromCity" value={request.fromCity} onChange={e => handleInputChange(index, e)} />
                    <br />
                    <label className="calc-label">Id города "до":</label>
                    <input className="item" type="number" name="toCity" value={request.toCity} onChange={e => handleInputChange(index, e)} />
                    <br />
                </div>
            ))}
            <br />
            <div id='request-calculate'>
            <button className = "addButton" onClick={handleAddRequest}>Добавить запрос</button>
            <button onClick={handleCalculateDistance}>Рассчитать расстояние</button>
            <br />
            {response.map((distance, index) => (
                <div key={index}>Рассчёт № {index + 1} Расстояние: {distance}</div>
            ))}
            {error && <Alert variant="danger">{error}</Alert>}
            {success && <Alert variant="success">{success}</Alert>}
            </div>
        </div>
    );
}

export default CalculateDistance;
