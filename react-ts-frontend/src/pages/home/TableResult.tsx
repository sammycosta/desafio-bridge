import { Table, TableBody, TableCell, TableHead, TablePagination, TableRow } from '@mui/material'
import { useEffect, useState } from 'react'
import { getNumbers } from '../../services/NumbersService'
import { TableNumbers } from './model'

export default function TableResult() {
  const [rows, setRows] = useState<TableNumbers[]>([])
  const [page, setPage] = useState(0)
  const [rowsPerPage, setRowsPerPage] = useState(3)

  const handleChangePage = (event: unknown, newPage: number) => setPage(newPage)

  const handleChangeRowsPerPage = (event: React.ChangeEvent<HTMLInputElement>) => {
    setRowsPerPage(parseInt(event.target.value, 10))
    setPage(0)
  }

  useEffect(() => {
    getNumbers().then((response) => setRows(response.data.reverse()))
  }, [])

  return (
    <div>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>
              <strong>Primeiro Número</strong>
            </TableCell>
            <TableCell>
              <strong>Resultado</strong>
            </TableCell>
            <TableCell>
              <strong>Tempo de Cálculo</strong>
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row, i) => (
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
        component='div'
        count={rows.length}
        rowsPerPage={rowsPerPage}
        page={page}
        labelRowsPerPage='Resultados por página:'
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </div>
  )
}
