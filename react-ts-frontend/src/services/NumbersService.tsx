import axios from 'axios'

const SERVICE_BASE_URL = "http://localhost:8080/api"

interface numberInput {
  inputNumber: number
}

class NumbersService {

  getNumbers() {
    return axios.get(SERVICE_BASE_URL)
  }

  addNumbers(number: numberInput) {
    return axios.post(SERVICE_BASE_URL, (number))
  }

} export default new NumbersService()