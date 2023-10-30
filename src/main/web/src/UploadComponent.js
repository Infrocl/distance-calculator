import React, { useState } from 'react';
import axios from 'axios';
import Alert from 'react-bootstrap/Alert';

const UploadComponent = () => {
  const [file, setFile] = useState();
  const [dataType, setDataType] = useState('');
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(false);

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleDataTypeChange = (event) => {
    setDataType(event.target.value);
  };

  const handleFileUpload = async () => {
    const formData = new FormData();
    formData.append('file', file);

    try {
      await axios.post('http://localhost:8080/cities/upload?type=' + dataType, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });
      console.log('File uploaded successfully');
      setSuccess("Загрузка прошла успешно");
    } catch (error) {
      setError("Ошибка загрузки файла: проверьте формат файла и тип данных")
    }
  };


  return (
    <div>
      <h1>Загрузка данных</h1>
      <input className='upload' type="file" onChange={handleFileChange} />
      <br />
      <select className='upload' value={dataType} onChange={handleDataTypeChange}>
        <option value="">Тип данных</option>
        <option value="City">City</option>
        <option value="Distance">Distance</option>
      </select>
      <br />
      <button className='upload' onClick={handleFileUpload} disabled={!file || !dataType}>
        Загрузить
      </button>
      {error && <Alert variant="danger">{error}</Alert>}
      {success && <Alert variant="success">{success}</Alert>}
    </div>
  );
};


export default UploadComponent;