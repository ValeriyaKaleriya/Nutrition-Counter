$(document).ready(function () {

  var ingredients = {};
  var chosen_ingredients = [];
  var grams = [200, 150, 150];
  var i = 0;
  function getRecipes(url) {
    $.ajax({
      type: 'GET',
      url: url,
      success: function(data) {
       showRecipes(data);
      },
      error: function(xhr) { // if error occured

      },
      complete: function() {

      }
    });
  }

  function getIngredients(url) {
    $.ajax({
      type: 'GET',
      url: url,
      success: function(data) {
        var names = [];
        data.forEach(function (d) {
          ingredients[d.name] = d;
          names.push(d.name);
          $( "#ingredients" ).append('<option>' + d.name + '</option>');

        });
        $("#ingredients-input").on('input', function () {
          var val = this.value;
          if($('#ingredients option').filter(function(){
            return this.value.toUpperCase() === val.toUpperCase();
          }).length) {
            //send ajax request
            $('#ingredients-list').append('<br>' + ingredients[this.value].name +
              '</br> Kcal: '+ ingredients[this.value].detail.kcal +
            '</br> Fat: '+ ingredients[this.value].detail.fat +
            '</br> Protein: ' + ingredients[this.value].detail.protein +
            '</br> Carbs: ' + ingredients[this.value].detail.carb +
              '</br> <input type="text"/> ' +
              '</td>');
            chosen_ingredients.push(ingredients[this.value]);
          }
        });
      },
      error: function(xhr) { // if error occured

      },
      complete: function() {

      }
    });
  }

  getRecipes("/api/recipes");
  getIngredients("/api/ingredients");


  function showRecipes(data) {
    var recipe_names = ['green smoothie', 'energy smoothie', 'red smoothie', 'banana smoothie'];
    var recipes = {'green smoothie': {'items': '', 'kcal': 0, 'fat': 0, 'prot': 0, 'carb': 0},
      'energy smoothie': {'items': '', 'kcal': 0, 'fat': 0, 'prot': 0, 'carb': 0},
      'red smoothie': {'items': '', 'kcal': 0, 'fat': 0, 'prot': 0, 'carb': 0},
      'banana smoothie': {'items': '', 'kcal': 0, 'fat': 0, 'prot': 0, 'carb': 0}};
    data.forEach(function (d) {
      recipes[d.recipe.name].items += d.ingredient.name + ' ';
      recipes[d.recipe.name].kcal += Number(d.ingredient.detail.kcal);
      recipes[d.recipe.name].fat += d.ingredient.detail.fat;
      recipes[d.recipe.name].prot += d.ingredient.detail.protein;
      recipes[d.recipe.name].carb += d.ingredient.detail.carb;
    });

    for (i = 0; i < recipe_names.length; i++) {
      var rr = recipes[recipe_names[i]];
      $('#fill_recipes').append('<td>Ingredients: ' + rr.items
      + '</br> Kcal: ' + rr.kcal
      + '</br> Fat: ' + rr.fat
      + '</br> Protein: ' + rr.prot
      + '</br> Carbs: ' + rr.carb
        + '</td>');
    }
  }

  $('#calculate').click(function () {
      var data = {
        'ingredients': chosen_ingredients,
        'quantity': grams
      };
      $.ajax({
        type: 'POST',
        url: '/api/calculate',
        data: JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(data) {
          var nut = {'kcal': 0, 'fat': 0, 'prot': 0, 'carb': 0};
          data.forEach(function (d) {
             nut.kcal += Number(d.detail.kcal);
             nut.fat += d.detail.fat;
             nut.prot += d.detail.protein;
             nut.carb += d.detail.carb;
          });
          $('#nutrition').append('Your recipe\'s nutrition: </br>'+
          'Kcal: ' + nut.kcal + '</br>'+
          'Fat: ' + nut.fat + '</br>' +
          'Protein: ' + nut.prot + '</br>' +
          'Carbs: ' + nut.carb)
        },
        error: function(xhr) {

        },
        complete: function() {

        }
      });
  });

});
