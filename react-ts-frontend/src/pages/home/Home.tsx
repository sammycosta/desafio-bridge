import { useEffect, useState } from 'react'
import { getNumbers } from '../../services/NumbersService'
import NumberForm from './NumberForm'
import TableResult from './TableResult'
import { TableNumbers } from './model'

export default function Home() {
  const [rows, setRows] = useState<TableNumbers[]>([])

  const loadNumbers = () =>
    getNumbers().then((response) => {
      console.log(response.data)
      setRows(response.data.reverse())
    })

  useEffect(() => {
    loadNumbers()
  }, [])

  return (
    <>
      <nav className='navbar bg-dark fixed-top shadow-lg'>
        <div className='container-fluid'>
          <a className='navbar-brand text-white mx-auto' href='#'>
            Calculadora #DesafioBridge
          </a>
          <span className='navbar-text text-white mx-auto'>Por Samantha Costa</span>
        </div>
      </nav>
      <div className='App card-body card w-50 container-md mt-5'>
        <span className='card-text p-2 mb-1'>
          Insira um número inteiro k. O resultado será <strong>o número de inteiros positivos n menores que k</strong>,
          para os quais <strong>n e n + 1 têm o mesmo número de divisores positivos. </strong>
        </span>
        <NumberForm onSubmit={loadNumbers} />
        <TableResult rows={rows} />
      </div>
    </>
  )
}
