Because this is an interview assignemnt with limited time, I gave my efforts to pass a simple test for the whole service rather than following a TDD approch from the beginning, the test included calling mock services for the 2 suppliers, mapping response from suppliers to BusyFlightResponse and merging and sorting the results. this smoke test passed.

The 90 minutes were over before Some Important parts are implemented, these are:

1. Date formatting and validation.
2. Money formatting and validation.
3. Validations for nummber of passengers and IATA Codes.
4. Unit tests to cover total price calculations and all the above validations
5. Calling the supplier services in threads.
6. this is t1

