
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import ReactNavbar from "./components/ReactNavbar";
import BuildingView from './components/BuildingView'
import BuildingSet from './components/BuildingSet';
import "./assets/css/index.css";
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
   <div>
     <ReactNavbar />
     <BrowserRouter>
          <Routes>
            <Route path='/' element={<BuildingView />} exact/>
            <Route path='/set' element={<BuildingSet />} exact/>
          </Routes>
      </BrowserRouter>
   </div>
  );
}

export default App;
