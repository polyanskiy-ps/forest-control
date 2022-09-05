
Подсчёт веса дерева 
- java 11
- Liquibase
- Spring-boot 2
- PostgreSQL

POST - запрос по адресу: 
localhost:8080/topaz_tree


Пример JSON с деревом:

{
  "weight": 8,
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
