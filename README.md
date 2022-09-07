**POST сохранение дерева и возврат его веса:**  
localhost:8080/forest_control/save

**POST возврат веса переданного дерева:**  
localhost:8080/forest_control

**GET возврат всех деревьев:**  
localhost:8080/trees

**GET возврат дерева по id:**  
localhost:8080/tree{id}



**Пример JSON с деревом:**

{
  "weight": 8,
  "name": "test",
  "children": [
    {
      "weight": 3,
      "children": [
        {
          "weight": 1
        },
        {
          "weight": 6,
          "children": [
            {
              "weight": 4
            },
            {
              "weight": 7
            }
          ]
        }
      ]
    },
    {
      "weight": 10,
      "children": [
        {
          "weight": 14,
          "children": [
            {
              "weight": 13
            }
          ]
        }
      ]
    }
  ]
}
