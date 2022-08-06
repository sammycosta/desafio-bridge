import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './styles/index.css'
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";

document.body.style.backgroundColor = "#24252e";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
