import { Pipe, PipeTransform } from '@angular/core';
import { EnumRole } from 'src/app/models/role-models/enum-roles';

@Pipe({
  name: 'rolesFormat'
})
export class RolesFormatPipe implements PipeTransform {

  transform(value: EnumRole[]): string {
    let output = "";
    let i = 0;
    for (i; i < value.length - 1; i++) {
      let stringRole = value[i].toString();
      stringRole = stringRole.substring(5);
      output += stringRole + ", ";
    }
    let stringRole = value[i].toString();
    stringRole = stringRole.substring(5);
    output += stringRole
    return output;
  }

}
