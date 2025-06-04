import axios from "axios";

const api = "http://localhost:8080/api/validateUser"


const validateUser = async (jsonData) => {

      try {
            const response = await axios.post(api, jsonData, {
                  headers: {
                        'Content-Type': 'application/json'
                  }
            });
            return response.data; // Return the data received from the API
      } catch (error) {
            console.error('Error:', error);
            return { error: error.message }; // Return an error object or handle it as needed
      }
}
// test feature branch

export default validateUser