import React, { useState } from 'react'
import { addNumbers } from '../../services/NumbersService'

export default function NumberForm() {
  const [inputNumber, setInputNumber] = useState('')
  const [resultNumber, setResultNumber] = useState('')
  const [calculationTime, setCalculationTime] = useState('')

  const handleChangeInput = (event: React.ChangeEvent<HTMLInputElement>) => {
    event.preventDefault()
    setInputNumber(event.target.value)
  }

  const saveNumber = (event: any) => {
    event.preventDefault()
    const data = { inputNumber: parseInt(inputNumber) }
    addNumbers(data).then((response) => {
      setInputNumber('')
      setResultNumber(response.data.resultNumber.toString())
      setCalculationTime(response.data.calculationTime.toString())
    })
  }

  return (
    <div className='container-md'>
      <form onSubmit={saveNumber} className='input-group mb-3'>
        <input
          className='form-control'
          aria-describedby='button-addon2'
          value={inputNumber}
          type='number'
          min='1'
          step='1'
          placeholder='Insira o inteiro'
          onChange={handleChangeInput}
        />
        <button className='btn btn-outline-secondary' id='button-addon2' type='submit'>
          Calcular
        </button>
      </form>
      {resultNumber.length > 0 && (
        <>
          <span className='card-text mt-0'>
            <strong>Resultado:</strong> {resultNumber} |
          </span>
          <span className='card-text mt-0'>
            <strong>Tempo de Cálculo:</strong> {calculationTime} ns
            <em>**Não inclui tempo de operações em banco de dados</em>
          </span>
        </>
      )}
    </div>
  )
}
