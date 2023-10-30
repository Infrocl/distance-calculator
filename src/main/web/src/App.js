
import "./index.css"
import HomePage from "./HomePage";
import { Route, Routes } from "react-router-dom";
import CityComponent from "./CityComponent"
import CalculateDistance from "./CalculateDistance";
import UploadComponent from "./UploadComponent";
export default function App() {
  return (
    <Routes>
    <Route path="/cities/all" element={ <CityComponent/> } />
    <Route path="/cities/calculate" element={ <CalculateDistance/> } />
    <Route path="/cities/upload" element={ <UploadComponent/> } />
    <Route path="/*"  element={ <HomePage/> } />
    </Routes>
  );
}


