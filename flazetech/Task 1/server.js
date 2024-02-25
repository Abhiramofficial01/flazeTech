const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

app.post('/api/reservations', (req, res) => {
  const { name, date, time } = req.body;

  // Here you can save the reservation data to a database or perform other backend operations
  // For simplicity, we'll just send a success response
  res.json({ status: 'success', message: 'Reservation submitted successfully' });
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
