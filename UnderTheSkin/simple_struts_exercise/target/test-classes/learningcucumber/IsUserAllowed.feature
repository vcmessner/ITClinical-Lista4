Feature: Is user allowed?
Check if the user is allowed to proceed

    Scenario Outline: user is (Dis)allowed in the specific dates conting from today
        Given the name "<inputName>", the country "<inputCountry>", has elapsed <inputYears> years <inputMonths> months <inputDays> days
        When we want to abstract the user date input and check if the day intervals provide valid reply
        Then user allowed value is "<answer>"

        Examples:
        | inputName      |   inputCountry    | inputYears     | inputMonths      | inputDays      |  answer |
        | Algo           |       UK          | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Sunday         |       UK          | 18             | 0                | 0              |  True   | #18 years (6574 Days)
        | Sunday         |       UK          | 18             | 0                | -1             |  False  | #18 years -1 day (6573 Days)
        | John           |       UK          | 21             | 0                | 0              |  True   | #21 years (7670 Days)
        | John           |       UK          | 21             | 0                | -1             |  True   | #21 years (7670 Days)
        | Algo           |       UK          | 16             | 0                | 0              |  False  | #15 years (5478 Days)
        | Algo           |       UK          | 16             | 0                | -1             |  False  |
        | Algo           |       UK          | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |       UK          | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |       US          | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Sunday         |       US          | 18             | 0                | 0              |  False  | #18 years (6574 Days)
        | Sunday         |       US          | 18             | 0                | -1             |  False  | #18 years -1 day (6573 Days)
        | John           |       US          | 21             | 0                | 0              |  True   | #21 years (7670 Days)
        | John           |       US          | 21             | 0                | -1             |  False  | #21 years (7670 Days)
        | Algo           |       US          | 16             | 0                | 0              |  False  | #15 years (5478 Days)
        | Algo           |       US          | 16             | 0                | -1             |  False  |
        | Algo           |       US          | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |       US          | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |     Portugal      | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Sunday         |     Portugal      | 18             | 0                | 0              |  True   | #18 years (6574 Days)
        | Sunday         |     Portugal      | 18             | 0                | -1             |  True   | #18 years -1 day (6573 Days)
        | John           |     Portugal      | 21             | 0                | 0              |  True   | #21 years (7670 Days)
        | John           |     Portugal      | 21             | 0                | -1             |  True   | #21 years (7670 Days)
        | Algo           |     Portugal      | 16             | 0                | 0              |  True   | #15 years (5478 Days)
        | Algo           |     Portugal      | 16             | 0                | -1             |  False  |
        | Algo           |     Portugal      | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |     Portugal      | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |      Spain        | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Sunday         |      Spain        | 18             | 0                | 0              |  True   | #18 years (6574 Days)
        | Sunday         |      Spain        | 18             | 0                | -1             |  True   | #18 years -1 day (6573 Days)
        | John           |      Spain        | 21             | 0                | 0              |  True   | #21 years (7670 Days)
        | John           |      Spain        | 21             | 0                | -1             |  True   | #21 years (7670 Days)
        | Algo           |      Spain        | 16             | 0                | 0              |  True   | #15 years (5478 Days)
        | Algo           |      Spain        | 16             | 0                | -1             |  False  |
        | Algo           |      Spain        | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |      Spain        | 100            | 100              | 100            |  False  | (invalid input name)