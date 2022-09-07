**POST сохранение дерева и возврат его веса:**  
localhost:15410/api/v1/forest/save

**POST возврат веса переданного дерева:**  
localhost:15410/api/v1/forest

**GET возврат всех деревьев:**  
localhost:15410/api/v1/forest

**GET возврат дерева по id:**  
localhost:15410/api/v1/forest/tree



**Пример JSON с деревом:**

{ 
"name": "Tree1",
"weight": 80,
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