import { Table, TableBody, TableCell, TableHead, TablePagination, TableRow } from '@mui/material'
import React from 'react'
import NumbersService from '../services/NumbersService'

type TableNumbers = {
  inputNumber: string,
  resultNumber: string,
  calculationTime: string
}
interface Table {
  rows: Array<TableNumbers>,
  page: number,
  rowsPerPage: number
}
class TableResult extends React.Component<{}, Table> {
  constructor(props: {}) {
    super(props)
    this.state = {
      rows: [],
      page: 0,
      rowsPerPage: 3
    }

    this.handleChangePage = this.handleChangePage.bind(this);
    this.handleChangeRowsPerPage = this.handleChangeRowsPerPage.bind(this);
  }

  componentDidMount() {
    NumbersService.getNumbers().then(
      (response) => {
        this.setState({ rows: response.data })
      })
  }

  componentDidUpdate() {
    NumbersService.getNumbers().then(
      (response) => {
        this.setState({ rows: response.data.reverse() })
      })
  }

  handleChangePage = (event: unknown, newPage: number) => {
    this.setState({ page: newPage })
  }

  handleChangeRowsPerPage = (event: React.ChangeEvent<HTMLInputElement>) => {
    this.setState({ rowsPerPage: parseInt(event.target.value, 10), page: 0 })
  }

  render() {
    return (
      <div>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell><strong>Primeiro Número</strong></TableCell>
              <TableCell><strong>Resultado</strong></TableCell>
              <TableCell><strong>Tempo de Cálculo</strong></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {this.state.rows.slice(this.state.page * this.state.rowsPerPage, this.state.page * this.state.rowsPerPage + this.state.rowsPerPage).map((row, i) => (
              <TableRow key={i}>
                <TableCell>{row.inputNumber}</TableCell>
                <TableCell>{row.resultNumber}</TableCell>
                <TableCell>{row.calculationTime} ns</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
        <TablePagination
          rowsPerPageOptions={[3, 5, 10]}
          component="div"
          count={this.state.rows.length}
          rowsPerPage={this.state.rowsPerPage}
          page={this.state.page}
          onPageChange={this.handleChangePage}
          onRowsPerPageChange={this.handleChangeRowsPerPage}
          labelRowsPerPage="Resultados por página:"
        />
      </div>)
  }
} export default TableResult