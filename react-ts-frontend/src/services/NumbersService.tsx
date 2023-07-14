import axios from 'axios'

const SERVICE_BASE_URL = 'http://localhost:8080/api'

interface numberInput {
  number: number
}

export const getNumbers = () => axios.get(SERVICE_BASE_URL)

export const addNumbers = (number: numberInput) => axios.post(SERVICE_BASE_URL, number)
