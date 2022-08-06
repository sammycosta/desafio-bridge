import './styles/App.css'
import InputComponent from './components/InputComponent'
import TableResult from './components/TableResultComponent'
function App() {

  return (
    <>
      <nav className="navbar bg-dark fixed-top shadow-lg">
        <div className="container-fluid">
          <a className="navbar-brand text-white mx-auto" href="#">Calculadora #DesafioBridge</a>
          <span className="navbar-text text-white mx-auto">
            Por Samantha Costa
          </span>
        </div>
      </nav>
      <div className="App card-body card w-50 container-md mt-5">
        <span className="card-text p-2 mb-1">Insira um número inteiro k. O resultado será <strong>o número de inteiros positivos n menores que k</strong>, para os quais <strong>n e n + 1 têm o mesmo número de divisores positivos. </strong></span>
        <InputComponent />
        <TableResult />
      </div>
    </>
  )
}

export default App
