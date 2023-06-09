Feature: Is user allowed?
Check if the user is allowed to proceed

    Scenario Outline: user is (Dis)allowed in the specific dates conting from today
        Given the name "<inputName>", the country "<inputCountry>", has elapsed <inputYears> years <inputMonths> months <inputDays> days
        When we want to abstract the user date input and check if the day intervals provide valid reply
        Then user allowed value is "<answer>"

        Examples:
        | inputName      |   inputCountry    | inputYears     | inputMonths      | inputDays      |  answer |
        | Algo           |       UK          | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Sunday         |       UK          | 18             | 0                | 0              |  True   | #18 years -1 day (6573 Days)
        | Sunday         |       UK          | 18             | 0                | -1             |  False  | #18 years -1 day (6573 Days)
        | Algo           |       UK          | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |       UK          | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |       US          | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | John           |       US          | 21             | 0                | 0              |  True   | #21 years (7670 Days)
        | John           |       US          | 21             | 0                | -1             |  False  | #21 years -1 day (7670 Days)
        | Algo           |       US          | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |       US          | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |     Portugal      | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Algo           |     Portugal      | 16             | 0                | 0              |  True   | #16 years 
        | Algo           |     Portugal      | 16             | 0                | -1             |  False  | #16 years -1 day
        | Algo           |     Portugal      | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |     Portugal      | 100            | 100              | 100            |  False  | (invalid input name)
        | Algo           |      Spain        | 100            | 100              | 100            |  True   | #100 years (36525 days)
        | Algo           |      Spain        | 16             | 0                | 0              |  True   | #16 years 
        | Algo           |      Spain        | 16             | 0                | -1             |  False  | #16 years -1 day
        | Algo           |      Spain        | 0              | 0                | 30             |  False  | #0 years (30 days)
        |                |      Spain        | 100            | 100              | 100            |  False  | (invalid input name)
        