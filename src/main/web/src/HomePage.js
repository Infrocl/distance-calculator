import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <div>
      <h1> Домашняя страница</h1>
      <p> Добро пожаловать на домашнюю страницу!</p>
      <br></br> <Link to="/cities/all">Перейти к списку городов </ Link> 
      <br></br> < Link to="/cities/calculate">Узнать расстояние между городами</Link>
      <br></br> <Link to="/cities/upload">Загрузить данные</Link>
    </div>
  );
};

export default HomePage;