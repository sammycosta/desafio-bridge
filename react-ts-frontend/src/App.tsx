import './App.css'
import InputComponent from './components/InputComponent'
import TableResult from './components/TableResultComponent'

function App() {

  return (
    <div className="App">
      <h1>Calculadora</h1>
      <p>Insira um número inteiro k. O resultado será o número de inteiros positivos n menores que k, para os quais n e n + 1 têm o mesmo número de divisores positivos.</p>
      <InputComponent />
      <TableResult />
    </div>
  )
}

export default App
