import React from 'react';
import NumbersService from '../services/NumbersService';

interface Numbers {
  inputNumber: string
  resultNumber: string,
  calculationTime: string
}

class InputComponent extends React.Component<{}, Numbers> {
  constructor(props: {}) {
    super(props)
    this.state = {
      inputNumber: "",
      resultNumber: "",
      calculationTime: ""
    }

    this.handleChangeInput = this.handleChangeInput.bind(this);
    this.saveNumber = this.saveNumber.bind(this);
  };

  handleChangeInput = (event: React.ChangeEvent<HTMLInputElement>) => {
    event.preventDefault()
    this.setState({ inputNumber: event.target.value })
  }

  saveNumber = (event: any) => {
    event.preventDefault();
    const data = { inputNumber: parseInt(this.state.inputNumber) }
    NumbersService.addNumbers(data).then(
      (response) => {
        this.setState({
          inputNumber: "",
          resultNumber: (response.data.resultNumber).toString(),
          calculationTime: (response.data.calculationTime).toString()
        })
      }
    )
  }

  render(): React.ReactNode {
    return (
      <div>
        <form onSubmit={this.saveNumber}>
          <input value={this.state.inputNumber} type="number" min="1" step="1" placeholder='Insira o inteiro' onChange={this.handleChangeInput} />
          <button type="submit">Calcular</button>
          {this.state.resultNumber.length > 0 && (
            <>
              <p>Resultado: {this.state.resultNumber}</p>
              <p>Tempo de Cálculo: {this.state.calculationTime} ns</p>
            </>
          )}
        </form>
      </div>
    )
  }

} export default InputComponent