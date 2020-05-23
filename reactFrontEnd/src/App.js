import React, { useEffect, useState} from 'react';
import nature from './nature.jpg';
import trek from './trek.png';
//import './App.css';
import Routes from "./routes";
import { Link, useHistory } from 'react-router-dom';

function App(){
  const history = useHistory();
  const [path, setPath] = useState("");

  window.addEventListener("load", () => {

    if(window.location.pathname === "/contact"){
      setPath(window.location.pathname);
    }
  });

  const checkPath = () => {
    history.listen((location) => {
      setPath(location.name);
    });
  }

  useEffect(() => {
    checkPath();
  }, []);

  const showContact = path;
  let _contact;

  if(showContact !== "/contact"){
    _contact = (<li><Link to = '/contact'>Contact Us</Link></li>)

  }

  return (
    <div className="App">
      <div className="container">
        <nav>
          <ul>
            <li><Link to ="/">Healthcare Portal</Link></li>
          </ul>
          <ul>
            {_contact}
          </ul>
        </nav>
        <Routes />
      </div>
    </div>
  );
}

export default App;
