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
      <div className="container-md">
        <form onSubmit={this.saveNumber} className="input-group mb-3">
          <input className="form-control" aria-describedby="button-addon2" value={this.state.inputNumber} type="number" min="1" step="1" placeholder='Insira o inteiro' onChange={this.handleChangeInput} />
          <button className="btn btn-outline-secondary" id="button-addon2" type="submit">Calcular</button>
        </form>
        {this.state.resultNumber.length > 0 && (
          <>
            <span className="card-text mt-0"><strong>Resultado:</strong> {this.state.resultNumber} | </span>
            <span className="card-text mt-0"><strong>Tempo de Cálculo:</strong> {this.state.calculationTime} ns <em>**Não inclui tempo de operações em banco de dados</em></span>
          </>
        )}
      </div>
    )
  }

} export default InputComponent